package com.kcdata.abe.bapi;
public class Y_Bapi_Get_Alerts_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Get_Alerts.PortType", new java.lang.Object[][][]{{{"Y_BAPI_GET_ALERTS", "y_Bapi_Get_Alerts", "Y_BAPI_GET_ALERTS"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_ALERTS.Input", "com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_GET_ALERTS.Output", "com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1248193921515L) ;

    public  Y_Bapi_Get_Alerts_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Output y_Bapi_Get_Alerts(com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Input Y_Bapi_Get_Alerts_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Get_Alerts_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Get_Alerts.PortType", "Y_BAPI_GET_ALERTS", new com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
