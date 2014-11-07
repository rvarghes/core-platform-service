package com.kcdata.abe.bapi;
public class Y_Bapi_Add_Comments_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Add_Comments.PortType", new java.lang.Object[][][]{{{"Y_BAPI_ADD_COMMENTS", "y_Bapi_Add_Comments", "Y_BAPI_ADD_COMMENTS"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_ADD_COMMENTS.Input", "com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_ADD_COMMENTS.Output", "com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Add_Comments_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1256262725015L) ;

    public  Y_Bapi_Add_Comments_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Output y_Bapi_Add_Comments(com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Input Y_Bapi_Add_Comments_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Add_Comments_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Add_Comments.PortType", "Y_BAPI_ADD_COMMENTS", new com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
