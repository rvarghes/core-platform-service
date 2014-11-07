package com.kcdata.abe.bapi;
public class Z_Api_Send_Mail_Itin_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_API_SEND_MAIL_ITIN.PortType", new java.lang.Object[][][]{{{"Z_API_SEND_MAIL_ITIN", "z_Api_Send_Mail_Itin", "Z_API_SEND_MAIL_ITIN"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_SEND_MAIL_ITIN.Input", "com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_SEND_MAIL_ITIN.Output", "com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1318915570252L) ;

    public  Z_Api_Send_Mail_Itin_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Output z_Api_Send_Mail_Itin(com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Input Z_Api_Send_Mail_Itin_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Send_Mail_Itin_Input, "urn:sap-com:document:sap:rfc:functions", "Z_API_SEND_MAIL_ITIN.PortType", "Z_API_SEND_MAIL_ITIN", new com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
