package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Carri_InfoType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 169029438L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_CARRI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType(), new java.lang.String[][]{}, 52, 104, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_CARRI_INFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Refined Flight Search for BAPI</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>52</ifr:internalLength1><ifr:internalLength2>104</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Carri_InfoType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int indexOfYst_Bapi_Carri_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType item) {
        return baseList().indexOf(item);
    }

    public boolean removeYst_Bapi_Carri_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType item) {
        return baseList().remove(item);
    }

    public boolean containsYst_Bapi_Carri_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType item) {
        return baseList().contains(item);
    }

    public void addYst_Bapi_Carri_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType item) {
        baseList().add(item);
    }

    public void addYst_Bapi_Carri_InfoType(int index, com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType item) {
        baseList().add(index, item);
    }

    public boolean containsAllYst_Bapi_Carri_InfoType(Yst_Bapi_Carri_InfoType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType[] toArrayYst_Bapi_Carri_InfoType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType[] {});
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType setYst_Bapi_Carri_InfoType(int index, com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType)baseList().set(index, item);
    }

    public int lastIndexOfYst_Bapi_Carri_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType item) {
        return baseList().lastIndexOf(item);
    }

    public void addAllYst_Bapi_Carri_InfoType(Yst_Bapi_Carri_InfoType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType removeYst_Bapi_Carri_InfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType)baseList().remove(index);
    }

    public void addAllYst_Bapi_Carri_InfoType(int index, Yst_Bapi_Carri_InfoType_List item) {
        baseList().addAll(index, item);
    }

    public Yst_Bapi_Carri_InfoType_List subListYst_Bapi_Carri_InfoType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Carri_InfoType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType getYst_Bapi_Carri_InfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType)baseList().get(index);
    }

}
