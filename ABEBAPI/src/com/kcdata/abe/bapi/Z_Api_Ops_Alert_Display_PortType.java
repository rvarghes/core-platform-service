package com.kcdata.abe.bapi;
public class Z_Api_Ops_Alert_Display_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Api_Ops_Alert_Display.PortType", new java.lang.Object[][][]{{{"Z_API_OPS_ALERT_DISPLAY", "z_Api_Ops_Alert_Display", "Z_API_OPS_ALERT_DISPLAY"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_OPS_ALERT_DISPLAY.Input", "com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_OPS_ALERT_DISPLAY.Output", "com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1257710242375L) ;

    public  Z_Api_Ops_Alert_Display_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Output z_Api_Ops_Alert_Display(com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Input Z_Api_Ops_Alert_Display_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Ops_Alert_Display_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Api_Ops_Alert_Display.PortType", "Z_API_OPS_ALERT_DISPLAY", new com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
