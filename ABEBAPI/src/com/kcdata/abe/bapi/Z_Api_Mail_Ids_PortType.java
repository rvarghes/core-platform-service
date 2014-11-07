package com.kcdata.abe.bapi;
public class Z_Api_Mail_Ids_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Api_Mail_Ids.PortType", new java.lang.Object[][][]{{{"Z_API_MAIL_IDS", "z_Api_Mail_Ids", "Z_API_MAIL_IDS"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_MAIL_IDS.Input", "com.kcdata.abe.bapi.Z_Api_Mail_Ids_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_MAIL_IDS.Output", "com.kcdata.abe.bapi.Z_Api_Mail_Ids_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Mail_Ids_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1261070214203L) ;

    public  Z_Api_Mail_Ids_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Mail_Ids_Output z_Api_Mail_Ids(com.kcdata.abe.bapi.Z_Api_Mail_Ids_Input Z_Api_Mail_Ids_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Mail_Ids_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Api_Mail_Ids.PortType", "Z_API_MAIL_IDS", new com.kcdata.abe.bapi.Z_Api_Mail_Ids_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Mail_Ids_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Mail_Ids_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
