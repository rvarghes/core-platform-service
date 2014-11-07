package com.kcdata.abe.bapi;
public class Z_Get_City_Pair_For_Charter_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Get_City_Pair_For_Charter.PortType", new java.lang.Object[][][]{{{"Z_GET_CITY_PAIR_FOR_CHARTER", "z_Get_City_Pair_For_Charter", "Z_GET_CITY_PAIR_FOR_CHARTER"}, {"urn:sap-com:document:sap:rfc:functions:Z_GET_CITY_PAIR_FOR_CHARTER.Input", "com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_GET_CITY_PAIR_FOR_CHARTER.Output", "com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1260552658312L) ;

    public  Z_Get_City_Pair_For_Charter_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Output z_Get_City_Pair_For_Charter(com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Input Z_Get_City_Pair_For_Charter_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Get_City_Pair_For_Charter_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Get_City_Pair_For_Charter.PortType", "Z_GET_CITY_PAIR_FOR_CHARTER", new com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Output)){
        return (com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
