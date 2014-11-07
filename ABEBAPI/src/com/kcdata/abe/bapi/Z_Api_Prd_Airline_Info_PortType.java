package com.kcdata.abe.bapi;
public class Z_Api_Prd_Airline_Info_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Api_Prd_Airline_Info.PortType", new java.lang.Object[][][]{{{"Z_API_PRD_AIRLINE_INFO", "z_Api_Prd_Airline_Info", "Z_API_PRD_AIRLINE_INFO"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_PRD_AIRLINE_INFO.Input", "com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_PRD_AIRLINE_INFO.Output", "com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1247175272234L) ;

    public  Z_Api_Prd_Airline_Info_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Output z_Api_Prd_Airline_Info(com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Input Z_Api_Prd_Airline_Info_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Prd_Airline_Info_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Api_Prd_Airline_Info.PortType", "Z_API_PRD_AIRLINE_INFO", new com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
