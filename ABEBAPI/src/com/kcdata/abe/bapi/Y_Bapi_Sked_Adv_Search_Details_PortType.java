package com.kcdata.abe.bapi;
public class Y_Bapi_Sked_Adv_Search_Details_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Sked_Adv_Search_Details.PortType", new java.lang.Object[][][]{{{"Y_BAPI_SKED_ADV_SEARCH_DETAILS", "y_Bapi_Sked_Adv_Search_Details", "Y_BAPI_SKED_ADV_SEARCH_DETAILS"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_SKED_ADV_SEARCH_DETAILS.Input", "com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_SKED_ADV_SEARCH_DETAILS.Output", "com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1250104867296L) ;

    public  Y_Bapi_Sked_Adv_Search_Details_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Output y_Bapi_Sked_Adv_Search_Details(com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Input Y_Bapi_Sked_Adv_Search_Details_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Sked_Adv_Search_Details_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Sked_Adv_Search_Details.PortType", "Y_BAPI_SKED_ADV_SEARCH_DETAILS", new com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
