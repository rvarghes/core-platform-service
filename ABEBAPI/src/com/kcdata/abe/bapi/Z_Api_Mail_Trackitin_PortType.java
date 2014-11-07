package com.kcdata.abe.bapi;
public class Z_Api_Mail_Trackitin_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_API_MAIL_TRACKITIN.PortType", new java.lang.Object[][][]{{{"Z_API_MAIL_TRACKITIN", "z_Api_Mail_Trackitin", "Z_API_MAIL_TRACKITIN"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_MAIL_TRACKITIN.Input", "com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_MAIL_TRACKITIN.Output", "com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1318915552078L) ;

    public  Z_Api_Mail_Trackitin_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Output z_Api_Mail_Trackitin(com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Input Z_Api_Mail_Trackitin_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Mail_Trackitin_Input, "urn:sap-com:document:sap:rfc:functions", "Z_API_MAIL_TRACKITIN.PortType", "Z_API_MAIL_TRACKITIN", new com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
