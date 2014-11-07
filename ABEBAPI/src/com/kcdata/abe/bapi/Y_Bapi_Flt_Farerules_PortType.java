package com.kcdata.abe.bapi;
public class Y_Bapi_Flt_Farerules_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Flt_Farerules.PortType", new java.lang.Object[][][]{{{"Y_BAPI_FLT_FARERULES", "y_Bapi_Flt_Farerules", "Y_BAPI_FLT_FARERULES"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_FLT_FARERULES.Input", "com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_FLT_FARERULES.Output", "com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1250262545421L) ;

    public  Y_Bapi_Flt_Farerules_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Output y_Bapi_Flt_Farerules(com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Input Y_Bapi_Flt_Farerules_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Flt_Farerules_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Flt_Farerules.PortType", "Y_BAPI_FLT_FARERULES", new com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
