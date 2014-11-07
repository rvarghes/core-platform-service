package com.kcdata.abe.bapi.util;
public class Yst_Bapi_CreditcardsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -337468094L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_CREDITCARDS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType.class, new com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType(), new java.lang.String[][]{}, 24, 48, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_CREDITCARDS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Agency Credit card info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>24</ifr:internalLength1><ifr:internalLength2>48</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_CreditcardsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType setYst_Bapi_CreditcardsType(int index, com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType)baseList().set(index, item);
    }

    public Yst_Bapi_CreditcardsType_List subListYst_Bapi_CreditcardsType(int fromIndex, int toIndex) {
        return (Yst_Bapi_CreditcardsType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType[] toArrayYst_Bapi_CreditcardsType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType[] {});
    }

    public boolean containsYst_Bapi_CreditcardsType(com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType item) {
        return baseList().contains(item);
    }

    public void addAllYst_Bapi_CreditcardsType(int index, Yst_Bapi_CreditcardsType_List item) {
        baseList().addAll(index, item);
    }

    public int lastIndexOfYst_Bapi_CreditcardsType(com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfYst_Bapi_CreditcardsType(com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType item) {
        return baseList().indexOf(item);
    }

    public boolean containsAllYst_Bapi_CreditcardsType(Yst_Bapi_CreditcardsType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Bapi_CreditcardsType(int index, com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType item) {
        baseList().add(index, item);
    }

    public void addYst_Bapi_CreditcardsType(com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType item) {
        baseList().add(item);
    }

    public boolean removeYst_Bapi_CreditcardsType(com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType getYst_Bapi_CreditcardsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType)baseList().get(index);
    }

    public void addAllYst_Bapi_CreditcardsType(Yst_Bapi_CreditcardsType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType removeYst_Bapi_CreditcardsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType)baseList().remove(index);
    }

}
