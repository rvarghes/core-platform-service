package com.kcdata.abe.bapi;
public class Y_Ota_Pricing_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Ota_Pricing.PortType", new java.lang.Object[][][]{{{"Y_OTA_PRICING", "y_Ota_Pricing", "Y_OTA_PRICING"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_PRICING.Input", "com.kcdata.abe.bapi.Y_Ota_Pricing_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_OTA_PRICING.Output", "com.kcdata.abe.bapi.Y_Ota_Pricing_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Ota_Pricing_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1341668201178L) ;

    public  Y_Ota_Pricing_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Ota_Pricing_Output y_Ota_Pricing(com.kcdata.abe.bapi.Y_Ota_Pricing_Input Y_Ota_Pricing_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Ota_Pricing_Input, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_PRICING.PortType", "Y_OTA_PRICING", new com.kcdata.abe.bapi.Y_Ota_Pricing_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Ota_Pricing_Output)){
        return (com.kcdata.abe.bapi.Y_Ota_Pricing_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
