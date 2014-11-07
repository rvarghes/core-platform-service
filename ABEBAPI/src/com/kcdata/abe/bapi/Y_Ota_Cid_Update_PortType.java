package com.kcdata.abe.bapi;
public class Y_Ota_Cid_Update_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Ota_Cid_Update.PortType", new java.lang.Object[][][]{{{"Y_OTA_CID_UPDATE", "y_Ota_Cid_Update", "Y_OTA_CID_UPDATE"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_CID_UPDATE.Input", "com.kcdata.abe.bapi.Y_Ota_Cid_Update_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_CID_UPDATE.Output", "com.kcdata.abe.bapi.Y_Ota_Cid_Update_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Ota_Cid_Update_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1396186757437L) ;

    public  Y_Ota_Cid_Update_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Ota_Cid_Update_Output y_Ota_Cid_Update(com.kcdata.abe.bapi.Y_Ota_Cid_Update_Input Y_Ota_Cid_Update_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Ota_Cid_Update_Input, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_CID_UPDATE.PortType", "Y_OTA_CID_UPDATE", new com.kcdata.abe.bapi.Y_Ota_Cid_Update_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Ota_Cid_Update_Output)){
        return (com.kcdata.abe.bapi.Y_Ota_Cid_Update_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
