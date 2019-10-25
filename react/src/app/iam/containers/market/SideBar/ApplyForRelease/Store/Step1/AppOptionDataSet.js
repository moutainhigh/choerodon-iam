import { axios } from '@choerodon/boot';

export default function (projectId) {
  return {
    paging: false,
    dataKey: null,
    fields: [
      { name: 'id', type: 'number' },
      { name: 'name', type: 'string' },
      { name: 'description', type: 'string', label: '应用描述' },
    ],
    transport: {
      read: {
        url: `base/v1/projects/${projectId}/applications/brief_info`,
        method: 'get',
      },
    },
  };
}
