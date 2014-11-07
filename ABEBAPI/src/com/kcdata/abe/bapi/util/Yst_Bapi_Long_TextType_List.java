package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Long_TextType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -2063209752L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_LONG_TEXT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Long_TextType.class, new com.kcdata.abe.bapi.Yst_Bapi_Long_TextType(), new java.lang.String[][]{}, 137, 274, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_LONG_TEXT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">BAPI long text</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>137</ifr:internalLength1><ifr:internalLength2>274</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Long_TextType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Long_TextType removeYst_Bapi_Long_TextType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Long_TextType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Long_TextType setYst_Bapi_Long_TextType(int index, com.kcdata.abe.bapi.Yst_Bapi_Long_TextType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Long_TextType)baseList().set(index, item);
    }

    public void addYst_Bapi_Long_TextType(int index, com.kcdata.abe.bapi.Yst_Bapi_Long_TextType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Bapi_Long_TextType(Yst_Bapi_Long_TextType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Bapi_Long_TextType(com.kcdata.abe.bapi.Yst_Bapi_Long_TextType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Bapi_Long_TextType(Yst_Bapi_Long_TextType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Bapi_Long_TextType(com.kcdata.abe.bapi.Yst_Bapi_Long_TextType item) {
        baseList().add(item);
    }

    public void addAllYst_Bapi_Long_TextType(int index, Yst_Bapi_Long_TextType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_Bapi_Long_TextType(com.kcdata.abe.bapi.Yst_Bapi_Long_TextType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Long_TextType getYst_Bapi_Long_TextType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Long_TextType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Long_TextType[] toArrayYst_Bapi_Long_TextType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Long_TextType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Long_TextType[] {});
    }

    public int lastIndexOfYst_Bapi_Long_TextType(com.kcdata.abe.bapi.Yst_Bapi_Long_TextType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Bapi_Long_TextType_List subListYst_Bapi_Long_TextType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Long_TextType_List)baseList().subList(fromIndex, toIndex);
    }

    public int indexOfYst_Bapi_Long_TextType(com.kcdata.abe.bapi.Yst_Bapi_Long_TextType item) {
        return baseList().indexOf(item);
    }

}
