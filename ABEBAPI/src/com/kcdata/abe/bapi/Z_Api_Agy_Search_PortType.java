package com.kcdata.abe.bapi;
public class Z_Api_Agy_Search_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Api_Agy_Search.PortType", new java.lang.Object[][][]{{{"Z_API_AGY_SEARCH", "z_Api_Agy_Search", "Z_API_AGY_SEARCH"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_AGY_SEARCH.Input", "com.kcdata.abe.bapi.Z_Api_Agy_Search_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_AGY_SEARCH.Output", "com.kcdata.abe.bapi.Z_Api_Agy_Search_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Agy_Search_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1298379317921L) ;

    public  Z_Api_Agy_Search_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Agy_Search_Output z_Api_Agy_Search(com.kcdata.abe.bapi.Z_Api_Agy_Search_Input Z_Api_Agy_Search_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Agy_Search_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Api_Agy_Search.PortType", "Z_API_AGY_SEARCH", new com.kcdata.abe.bapi.Z_Api_Agy_Search_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Agy_Search_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Agy_Search_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
