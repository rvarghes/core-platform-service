package com.kcdata.abe.bapi;
public class Y_Ota_Change_Booking_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Ota_Change_Booking.PortType", new java.lang.Object[][][]{{{"Y_OTA_CHANGE_BOOKING", "y_Ota_Change_Booking", "Y_OTA_CHANGE_BOOKING"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_CHANGE_BOOKING.Input", "com.kcdata.abe.bapi.Y_Ota_Change_Booking_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_CHANGE_BOOKING.Output", "com.kcdata.abe.bapi.Y_Ota_Change_Booking_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Ota_Change_Booking_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1341668159090L) ;

    public  Y_Ota_Change_Booking_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Ota_Change_Booking_Output y_Ota_Change_Booking(com.kcdata.abe.bapi.Y_Ota_Change_Booking_Input Y_Ota_Change_Booking_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Ota_Change_Booking_Input, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_CHANGE_BOOKING.PortType", "Y_OTA_CHANGE_BOOKING", new com.kcdata.abe.bapi.Y_Ota_Change_Booking_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Ota_Change_Booking_Output)){
        return (com.kcdata.abe.bapi.Y_Ota_Change_Booking_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
