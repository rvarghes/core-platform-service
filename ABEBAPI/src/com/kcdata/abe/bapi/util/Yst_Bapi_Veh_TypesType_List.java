package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Veh_TypesType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 865145963L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_VEH_TYPES", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType.class, new com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType(), new java.lang.String[][]{}, 77, 154, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_VEH_TYPES\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Market Strategy for Rental car</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>77</ifr:internalLength1><ifr:internalLength2>154</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Veh_TypesType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType getYst_Bapi_Veh_TypesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType)baseList().get(index);
    }

    public int indexOfYst_Bapi_Veh_TypesType(com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType item) {
        return baseList().indexOf(item);
    }

    public int lastIndexOfYst_Bapi_Veh_TypesType(com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType removeYst_Bapi_Veh_TypesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType[] toArrayYst_Bapi_Veh_TypesType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType[] {});
    }

    public boolean containsAllYst_Bapi_Veh_TypesType(Yst_Bapi_Veh_TypesType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeYst_Bapi_Veh_TypesType(com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType item) {
        return baseList().remove(item);
    }

    public Yst_Bapi_Veh_TypesType_List subListYst_Bapi_Veh_TypesType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Veh_TypesType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addYst_Bapi_Veh_TypesType(int index, com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Bapi_Veh_TypesType(Yst_Bapi_Veh_TypesType_List item) {
        baseList().addAll(item);
    }

    public void addAllYst_Bapi_Veh_TypesType(int index, Yst_Bapi_Veh_TypesType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_Bapi_Veh_TypesType(com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType setYst_Bapi_Veh_TypesType(int index, com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType)baseList().set(index, item);
    }

    public void addYst_Bapi_Veh_TypesType(com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType item) {
        baseList().add(item);
    }

}
