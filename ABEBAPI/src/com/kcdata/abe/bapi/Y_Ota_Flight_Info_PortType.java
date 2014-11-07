package com.kcdata.abe.bapi;
public class Y_Ota_Flight_Info_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Ota_Flight_Info.PortType", new java.lang.Object[][][]{{{"Y_OTA_FLIGHT_INFO", "y_Ota_Flight_Info", "Y_OTA_FLIGHT_INFO"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_FLIGHT_INFO.Input", "com.kcdata.abe.bapi.Y_Ota_Flight_Info_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_FLIGHT_INFO.Output", "com.kcdata.abe.bapi.Y_Ota_Flight_Info_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Ota_Flight_Info_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1294269645406L) ;

    public  Y_Ota_Flight_Info_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Ota_Flight_Info_Output y_Ota_Flight_Info(com.kcdata.abe.bapi.Y_Ota_Flight_Info_Input Y_Ota_Flight_Info_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Ota_Flight_Info_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Ota_Flight_Info.PortType", "Y_OTA_FLIGHT_INFO", new com.kcdata.abe.bapi.Y_Ota_Flight_Info_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Ota_Flight_Info_Output)){
        return (com.kcdata.abe.bapi.Y_Ota_Flight_Info_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
