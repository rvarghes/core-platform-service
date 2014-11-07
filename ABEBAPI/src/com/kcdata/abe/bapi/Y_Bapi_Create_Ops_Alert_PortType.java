package com.kcdata.abe.bapi;
public class Y_Bapi_Create_Ops_Alert_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Create_Ops_Alert.PortType", new java.lang.Object[][][]{{{"Y_BAPI_CREATE_OPS_ALERT", "y_Bapi_Create_Ops_Alert", "Y_BAPI_CREATE_OPS_ALERT"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_CREATE_OPS_ALERT.Input", "com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_CREATE_OPS_ALERT.Output", "com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1254952178828L) ;

    public  Y_Bapi_Create_Ops_Alert_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Output y_Bapi_Create_Ops_Alert(com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Input Y_Bapi_Create_Ops_Alert_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Create_Ops_Alert_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Create_Ops_Alert.PortType", "Y_BAPI_CREATE_OPS_ALERT", new com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
