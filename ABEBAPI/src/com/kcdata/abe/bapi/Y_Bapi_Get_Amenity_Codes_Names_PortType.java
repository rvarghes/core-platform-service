package com.kcdata.abe.bapi;
public class Y_Bapi_Get_Amenity_Codes_Names_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Get_Amenity_Codes_Names.PortType", new java.lang.Object[][][]{{{"Y_BAPI_GET_AMENITY_CODES_NAMES", "y_Bapi_Get_Amenity_Codes_Names", "Y_BAPI_GET_AMENITY_CODES_NAMES"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_AMENITY_CODES_NAMES.Input", "com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_AMENITY_CODES_NAMES.Output", "com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1247866445359L) ;

    public  Y_Bapi_Get_Amenity_Codes_Names_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Output y_Bapi_Get_Amenity_Codes_Names(com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Input Y_Bapi_Get_Amenity_Codes_Names_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Get_Amenity_Codes_Names_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Get_Amenity_Codes_Names.PortType", "Y_BAPI_GET_AMENITY_CODES_NAMES", new com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
