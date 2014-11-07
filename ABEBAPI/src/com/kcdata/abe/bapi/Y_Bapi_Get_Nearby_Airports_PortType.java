package com.kcdata.abe.bapi;
public class Y_Bapi_Get_Nearby_Airports_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_NEARBY_AIRPORTS.PortType", new java.lang.Object[][][]{{{"Y_BAPI_GET_NEARBY_AIRPORTS", "y_Bapi_Get_Nearby_Airports", "Y_BAPI_GET_NEARBY_AIRPORTS"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_NEARBY_AIRPORTS.Input", "com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_NEARBY_AIRPORTS.Output", "com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1317392173014L) ;

    public  Y_Bapi_Get_Nearby_Airports_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Output y_Bapi_Get_Nearby_Airports(com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Input Y_Bapi_Get_Nearby_Airports_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Get_Nearby_Airports_Input, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_GET_NEARBY_AIRPORTS.PortType", "Y_BAPI_GET_NEARBY_AIRPORTS", new com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
