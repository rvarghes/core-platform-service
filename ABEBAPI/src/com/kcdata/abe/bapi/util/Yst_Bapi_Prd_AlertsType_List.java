package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Prd_AlertsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -2068869712L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_PRD_ALERTS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType.class, new com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType(), new java.lang.String[][]{}, 42, 84, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_PRD_ALERTS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Alerts Input Values</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>42</ifr:internalLength1><ifr:internalLength2>84</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Prd_AlertsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsYst_Bapi_Prd_AlertsType(com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType removeYst_Bapi_Prd_AlertsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType setYst_Bapi_Prd_AlertsType(int index, com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType)baseList().set(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType[] toArrayYst_Bapi_Prd_AlertsType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType[] {});
    }

    public void addAllYst_Bapi_Prd_AlertsType(int index, Yst_Bapi_Prd_AlertsType_List item) {
        baseList().addAll(index, item);
    }

    public int lastIndexOfYst_Bapi_Prd_AlertsType(com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfYst_Bapi_Prd_AlertsType(com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType getYst_Bapi_Prd_AlertsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType)baseList().get(index);
    }

    public void addAllYst_Bapi_Prd_AlertsType(Yst_Bapi_Prd_AlertsType_List item) {
        baseList().addAll(item);
    }

    public Yst_Bapi_Prd_AlertsType_List subListYst_Bapi_Prd_AlertsType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Prd_AlertsType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addYst_Bapi_Prd_AlertsType(int index, com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType item) {
        baseList().add(index, item);
    }

    public boolean removeYst_Bapi_Prd_AlertsType(com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Bapi_Prd_AlertsType(Yst_Bapi_Prd_AlertsType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Bapi_Prd_AlertsType(com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType item) {
        baseList().add(item);
    }

}
