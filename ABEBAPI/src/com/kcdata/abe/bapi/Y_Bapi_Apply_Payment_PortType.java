package com.kcdata.abe.bapi;
public class Y_Bapi_Apply_Payment_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Apply_Payment.PortType", new java.lang.Object[][][]{{{"Y_BAPI_APPLY_PAYMENT", "y_Bapi_Apply_Payment", "Y_BAPI_APPLY_PAYMENT"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_APPLY_PAYMENT.Input", "com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_APPLY_PAYMENT.Output", "com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1300368487796L) ;

    public  Y_Bapi_Apply_Payment_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Output y_Bapi_Apply_Payment(com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Input Y_Bapi_Apply_Payment_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Apply_Payment_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Apply_Payment.PortType", "Y_BAPI_APPLY_PAYMENT", new com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
