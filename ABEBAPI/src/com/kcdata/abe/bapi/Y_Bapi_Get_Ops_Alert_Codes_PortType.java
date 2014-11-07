package com.kcdata.abe.bapi;
public class Y_Bapi_Get_Ops_Alert_Codes_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Get_Ops_Alert_Codes.PortType", new java.lang.Object[][][]{{{"Y_BAPI_GET_OPS_ALERT_CODES", "y_Bapi_Get_Ops_Alert_Codes", "Y_BAPI_GET_OPS_ALERT_CODES"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_OPS_ALERT_CODES.Input", "com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_OPS_ALERT_CODES.Output", "com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1254952123750L) ;

    public  Y_Bapi_Get_Ops_Alert_Codes_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Output y_Bapi_Get_Ops_Alert_Codes(com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Input Y_Bapi_Get_Ops_Alert_Codes_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Get_Ops_Alert_Codes_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Get_Ops_Alert_Codes.PortType", "Y_BAPI_GET_OPS_ALERT_CODES", new com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
