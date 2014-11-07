package com.kcdata.abe.bapi;
public class Bapi_Transaction_Commit_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Bapi_Transaction_Commit.PortType", new java.lang.Object[][][]{{{"BAPI_TRANSACTION_COMMIT", "bapi_Transaction_Commit", "BAPI_TRANSACTION_COMMIT"}, {"urn:sap-com:document:sap:rfc:functions:BAPI_TRANSACTION_COMMIT.Input", "com.kcdata.abe.bapi.Bapi_Transaction_Commit_Input"}, {"urn:sap-com:document:sap:rfc:functions:BAPI_TRANSACTION_COMMIT.Output", "com.kcdata.abe.bapi.Bapi_Transaction_Commit_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Bapi_Transaction_Commit_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1336024535346L) ;

    public  Bapi_Transaction_Commit_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Bapi_Transaction_Commit_Output bapi_Transaction_Commit(com.kcdata.abe.bapi.Bapi_Transaction_Commit_Input Bapi_Transaction_Commit_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Bapi_Transaction_Commit_Input, "urn:sap-com:document:sap:rfc:functions", "BAPI_TRANSACTION_COMMIT.PortType", "BAPI_TRANSACTION_COMMIT", new com.kcdata.abe.bapi.Bapi_Transaction_Commit_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Bapi_Transaction_Commit_Output)){
        return (com.kcdata.abe.bapi.Bapi_Transaction_Commit_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
