import { DataSet } from 'choerodon-ui/pro';
import { runInAction } from 'mobx';

export default ({ id = 0, intl, intlPrefix, applicationId }) => {
  const name = intl.formatMessage({ id: 'name' });
  
  return {
    autoQuery: true,
    // selection: false,
    transport: {
      read: {
        url: `/base/v1/projects/${id}/applications/${applicationId}/services`,
        method: 'get',
        transformResponse: (data) => {
          data = JSON.parse(data);
          // eslint-disable-next-line no-unused-expressions
          data.list && data.list.forEach(service => {
            service.allAppServiceVersions = service.allAppServiceVersions && service.allAppServiceVersions.filter((noop, index) => index < 10).map(v => ({ ...v, id: v.id.toString() }));
          });
          return data;
        },
      },
    },
    fields: [
      { name: 'name', type: 'string', label: '应用服务' },
      { name: 'appServiceVersions',
        type: 'string',
        label: '应用服务版本',
        dynamicProps: ({ record }) => ({ 
          options: new DataSet({
            paging: false,
            data: record.get('allAppServiceVersions'),
            selection: 'single',
          }),
        }), 
        textField: 'version',
        valueField: 'id',
      },
    ],
    queryFields: [
      { name: 'name', type: 'string', label: '应用服务' },
    ],
    events: {
      load: ({ dataSet }) => {
        runInAction(() => {
          dataSet.forEach((record) => {
            record.selectable = !!record.get('allAppServiceVersions');
            record.set('appServiceVersions', record.get('allAppServiceVersions') && record.get('allAppServiceVersions')[0]);
          });
        });
      },
    },
  };
};
