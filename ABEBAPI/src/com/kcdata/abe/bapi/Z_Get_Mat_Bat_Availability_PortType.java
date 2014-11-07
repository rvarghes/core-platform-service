package com.kcdata.abe.bapi;
public class Z_Get_Mat_Bat_Availability_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_GET_MAT_BAT_AVAILABILITY.PortType", new java.lang.Object[][][]{{{"Z_GET_MAT_BAT_AVAILABILITY", "z_Get_Mat_Bat_Availability", "Z_GET_MAT_BAT_AVAILABILITY"}, {"urn:sap-com:document:sap:rfc:functions:Z_GET_MAT_BAT_AVAILABILITY.Input", "com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_GET_MAT_BAT_AVAILABILITY.Output", "com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Output"}, {"urn:sap-com:document:sap:rfc:functions:Z_GET_MAT_BAT_AVAILABILITY.Exception", "com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault_Exception", "com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1322472203967L) ;

    public  Z_Get_Mat_Bat_Availability_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Output z_Get_Mat_Bat_Availability(com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Input Z_Get_Mat_Bat_Availability_Input) throws com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault_Exception, com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Get_Mat_Bat_Availability_Input, "urn:sap-com:document:sap:rfc:functions", "Z_GET_MAT_BAT_AVAILABILITY.PortType", "Z_GET_MAT_BAT_AVAILABILITY", new com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
        if (e instanceof com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault_Exception) { throw (com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault_Exception)e;}
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Output)){
        return (com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
