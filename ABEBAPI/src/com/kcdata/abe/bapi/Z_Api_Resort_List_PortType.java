package com.kcdata.abe.bapi;
public class Z_Api_Resort_List_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Api_Resort_List.PortType", new java.lang.Object[][][]{{{"Z_API_RESORT_LIST", "z_Api_Resort_List", "Z_API_RESORT_LIST"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_RESORT_LIST.Input", "com.kcdata.abe.bapi.Z_Api_Resort_List_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_RESORT_LIST.Output", "com.kcdata.abe.bapi.Z_Api_Resort_List_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Resort_List_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1245945380171L) ;

    public  Z_Api_Resort_List_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Resort_List_Output z_Api_Resort_List(com.kcdata.abe.bapi.Z_Api_Resort_List_Input Z_Api_Resort_List_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Resort_List_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Api_Resort_List.PortType", "Z_API_RESORT_LIST", new com.kcdata.abe.bapi.Z_Api_Resort_List_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Resort_List_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Resort_List_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
