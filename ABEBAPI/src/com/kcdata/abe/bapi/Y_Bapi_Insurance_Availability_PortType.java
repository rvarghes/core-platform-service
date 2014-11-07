package com.kcdata.abe.bapi;
public class Y_Bapi_Insurance_Availability_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Insurance_Availability.PortType", new java.lang.Object[][][]{{{"Y_BAPI_INSURANCE_AVAILABILITY", "y_Bapi_Insurance_Availability", "Y_BAPI_INSURANCE_AVAILABILITY"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_INSURANCE_AVAILABILITY.Input", "com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_INSURANCE_AVAILABILITY.Output", "com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1341668215031L) ;

    public  Y_Bapi_Insurance_Availability_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Output y_Bapi_Insurance_Availability(com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Input Y_Bapi_Insurance_Availability_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Insurance_Availability_Input, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_INSURANCE_AVAILABILITY.PortType", "Y_BAPI_INSURANCE_AVAILABILITY", new com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
