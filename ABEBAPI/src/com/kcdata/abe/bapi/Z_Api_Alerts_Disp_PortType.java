package com.kcdata.abe.bapi;
public class Z_Api_Alerts_Disp_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_API_ALERTS_DISP.PortType", new java.lang.Object[][][]{{{"Z_API_ALERTS_DISP", "z_Api_Alerts_Disp", "Z_API_ALERTS_DISP"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_ALERTS_DISP.Input", "com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_ALERTS_DISP.Output", "com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Alerts_Disp_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1318915545198L) ;

    public  Z_Api_Alerts_Disp_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Output z_Api_Alerts_Disp(com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Input Z_Api_Alerts_Disp_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Alerts_Disp_Input, "urn:sap-com:document:sap:rfc:functions", "Z_API_ALERTS_DISP.PortType", "Z_API_ALERTS_DISP", new com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
