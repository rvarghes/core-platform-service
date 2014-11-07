package com.kcdata.abe.bapi;
public class Y_Api_Order_Pymt_Hist_Display_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Api_Order_Pymt_Hist_Display.PortType", new java.lang.Object[][][]{{{"Y_API_ORDER_PYMT_HIST_DISPLAY", "y_Api_Order_Pymt_Hist_Display", "Y_API_ORDER_PYMT_HIST_DISPLAY"}, {"urn:sap-com:document:sap:rfc:functions:Y_API_ORDER_PYMT_HIST_DISPLAY.Input", "com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_API_ORDER_PYMT_HIST_DISPLAY.Output", "com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1280932265843L) ;

    public  Y_Api_Order_Pymt_Hist_Display_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Output y_Api_Order_Pymt_Hist_Display(com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Input Y_Api_Order_Pymt_Hist_Display_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Api_Order_Pymt_Hist_Display_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Api_Order_Pymt_Hist_Display.PortType", "Y_API_ORDER_PYMT_HIST_DISPLAY", new com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Output)){
        return (com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
