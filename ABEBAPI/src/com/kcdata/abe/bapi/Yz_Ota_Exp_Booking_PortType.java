package com.kcdata.abe.bapi;
public class Yz_Ota_Exp_Booking_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Yz_Ota_Exp_Booking.PortType", new java.lang.Object[][][]{{{"YZ_OTA_EXP_BOOKING", "yz_Ota_Exp_Booking", "YZ_OTA_EXP_BOOKING"}, {"urn:sap-com:document:sap:rfc:functions:YZ_OTA_EXP_BOOKING.Input", "com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Input"}, {"urn:sap-com:document:sap:rfc:functions:YZ_OTA_EXP_BOOKING.Output", "com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1335853890421L) ;

    public  Yz_Ota_Exp_Booking_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Output yz_Ota_Exp_Booking(com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Input Yz_Ota_Exp_Booking_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Yz_Ota_Exp_Booking_Input, "urn:sap-com:document:sap:rfc:functions", "YZ_OTA_EXP_BOOKING.PortType", "YZ_OTA_EXP_BOOKING", new com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Output)){
        return (com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
