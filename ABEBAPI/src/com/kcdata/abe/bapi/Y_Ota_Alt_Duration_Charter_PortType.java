package com.kcdata.abe.bapi;
public class Y_Ota_Alt_Duration_Charter_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_OTA_ALT_DURATION_CHARTER.PortType", new java.lang.Object[][][]{{{"Y_OTA_ALT_DURATION_CHARTER", "y_Ota_Alt_Duration_Charter", "Y_OTA_ALT_DURATION_CHARTER"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_ALT_DURATION_CHARTER.Input", "com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_ALT_DURATION_CHARTER.Output", "com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1406544458369L) ;

    public  Y_Ota_Alt_Duration_Charter_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Output y_Ota_Alt_Duration_Charter(com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Input Y_Ota_Alt_Duration_Charter_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Ota_Alt_Duration_Charter_Input, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_ALT_DURATION_CHARTER.PortType", "Y_OTA_ALT_DURATION_CHARTER", new com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Output)){
        return (com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
