import React, { createContext } from 'react';
import { inject } from 'mobx-react';
import { injectIntl } from 'react-intl';
import { DataSet } from 'choerodon-ui/pro';
import LdapLoadClientDataSet from './LdapLoadClientDataSet';

const Store = createContext();
export default Store;

export const StoreProvider = injectIntl(inject('AppState')((props) => {
  const { children, AppState: { currentMenuType: { id: orgId } }, ldapId } = props;
  const ldapLoadClientDataSet = new DataSet(LdapLoadClientDataSet({ orgId, ldapId }));
  const value = {
    ...props,
    orgId,
    ldapLoadClientDataSet,
  };
  return (
    <Store.Provider value={value}>
      {children}
    </Store.Provider>
  );
}));
