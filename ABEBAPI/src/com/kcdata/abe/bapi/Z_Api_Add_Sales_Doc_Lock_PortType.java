package com.kcdata.abe.bapi;
public class Z_Api_Add_Sales_Doc_Lock_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Api_Add_Sales_Doc_Lock.PortType", new java.lang.Object[][][]{{{"Z_API_ADD_SALES_DOC_LOCK", "z_Api_Add_Sales_Doc_Lock", "Z_API_ADD_SALES_DOC_LOCK"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_ADD_SALES_DOC_LOCK.Input", "com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_ADD_SALES_DOC_LOCK.Output", "com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1276891379203L) ;

    public  Z_Api_Add_Sales_Doc_Lock_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Output z_Api_Add_Sales_Doc_Lock(com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Input Z_Api_Add_Sales_Doc_Lock_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Add_Sales_Doc_Lock_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Api_Add_Sales_Doc_Lock.PortType", "Z_API_ADD_SALES_DOC_LOCK", new com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
