package com.kcdata.abe.bapi;
public class Y_Ota_Flight_Availability_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_OTA_FLIGHT_AVAILABILITY.PortType", new java.lang.Object[][][]{{{"Y_OTA_FLIGHT_AVAILABILITY", "y_Ota_Flight_Availability", "Y_OTA_FLIGHT_AVAILABILITY"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_FLIGHT_AVAILABILITY.Input", "com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_FLIGHT_AVAILABILITY.Output", "com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Ota_Flight_Availability_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1365159516128L) ;

    public  Y_Ota_Flight_Availability_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Output y_Ota_Flight_Availability(com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Input Y_Ota_Flight_Availability_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Ota_Flight_Availability_Input, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_FLIGHT_AVAILABILITY.PortType", "Y_OTA_FLIGHT_AVAILABILITY", new com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Output)){
        return (com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
