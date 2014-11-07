package com.kcdata.abe.bapi;
public class Y_Bapi_Validate_Promo_Code_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Validate_Promo_Code.PortType", new java.lang.Object[][][]{{{"Y_BAPI_VALIDATE_PROMO_CODE", "y_Bapi_Validate_Promo_Code", "Y_BAPI_VALIDATE_PROMO_CODE"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_VALIDATE_PROMO_CODE.Input", "com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_VALIDATE_PROMO_CODE.Output", "com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1256179451203L) ;

    public  Y_Bapi_Validate_Promo_Code_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Output y_Bapi_Validate_Promo_Code(com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Input Y_Bapi_Validate_Promo_Code_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Validate_Promo_Code_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Validate_Promo_Code.PortType", "Y_BAPI_VALIDATE_PROMO_CODE", new com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
