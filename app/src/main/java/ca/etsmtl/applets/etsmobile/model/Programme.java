package ca.etsmtl.applets.etsmobile.model;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 2.0.0.4
//
// Created by Quasar Development at 15-01-2014
//
//---------------------------------------------------

import java.util.Hashtable;

import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import ca.etsmtl.applets.etsmobile.http.soap.ExtendedSoapSerializationEnvelope;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "programme")
public class Programme extends AttributeContainer implements KvmSerializable {

	@DatabaseField(id = true)
	public String code;
	@DatabaseField
	public String libelle;
	@DatabaseField
	public String profil;
	@DatabaseField
	public String statut;
	@DatabaseField
	public String sessionDebut;
	@DatabaseField
	public String sessionFin;
	@DatabaseField
	public String moyenne;
	@DatabaseField
	public String nbEquivalences;
	@DatabaseField
	public String nbCrsReussis;
	@DatabaseField
	public String nbCrsEchoues;
	@DatabaseField
	public String nbCreditsInscrits;
	@DatabaseField
	public String nbCreditsCompletes;
	@DatabaseField
	public String nbCreditsPotentiels;
	@DatabaseField
	public String nbCreditsRecherche;

	public Programme() {
	}

	public Programme(AttributeContainer inObj, ExtendedSoapSerializationEnvelope envelope) {

		if (inObj == null)
			return;

		SoapObject soapObject = (SoapObject) inObj;

		if (soapObject.hasProperty("code")) {
			Object obj = soapObject.getProperty("code");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					code = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				code = (String) obj;
			}
		}
		if (soapObject.hasProperty("libelle")) {
			Object obj = soapObject.getProperty("libelle");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					libelle = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				libelle = (String) obj;
			}
		}
		if (soapObject.hasProperty("profil")) {
			Object obj = soapObject.getProperty("profil");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					profil = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				profil = (String) obj;
			}
		}
		if (soapObject.hasProperty("statut")) {
			Object obj = soapObject.getProperty("statut");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					statut = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				statut = (String) obj;
			}
		}
		if (soapObject.hasProperty("sessionDebut")) {
			Object obj = soapObject.getProperty("sessionDebut");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					sessionDebut = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				sessionDebut = (String) obj;
			}
		}
		if (soapObject.hasProperty("sessionFin")) {
			Object obj = soapObject.getProperty("sessionFin");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					sessionFin = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				sessionFin = (String) obj;
			}
		}
		if (soapObject.hasProperty("moyenne")) {
			Object obj = soapObject.getProperty("moyenne");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					moyenne = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				moyenne = (String) obj;
			}
		}
		if (soapObject.hasProperty("nbEquivalences")) {
			Object obj = soapObject.getProperty("nbEquivalences");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					nbEquivalences = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				nbEquivalences = (String) obj;
			}
		}
		if (soapObject.hasProperty("nbCrsReussis")) {
			Object obj = soapObject.getProperty("nbCrsReussis");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					nbCrsReussis = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				nbCrsReussis = (String) obj;
			}
		}
		if (soapObject.hasProperty("nbCrsEchoues")) {
			Object obj = soapObject.getProperty("nbCrsEchoues");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					nbCrsEchoues = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				nbCrsEchoues = (String) obj;
			}
		}
		if (soapObject.hasProperty("nbCreditsInscrits")) {
			Object obj = soapObject.getProperty("nbCreditsInscrits");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					nbCreditsInscrits = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				nbCreditsInscrits = (String) obj;
			}
		}
		if (soapObject.hasProperty("nbCreditsCompletes")) {
			Object obj = soapObject.getProperty("nbCreditsCompletes");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					nbCreditsCompletes = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				nbCreditsCompletes = (String) obj;
			}
		}
		if (soapObject.hasProperty("nbCreditsPotentiels")) {
			Object obj = soapObject.getProperty("nbCreditsPotentiels");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					nbCreditsPotentiels = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				nbCreditsPotentiels = (String) obj;
			}
		}
		if (soapObject.hasProperty("nbCreditsRecherche")) {
			Object obj = soapObject.getProperty("nbCreditsRecherche");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				if (j.toString() != null) {
					nbCreditsRecherche = j.toString();
				}
			} else if (obj != null && obj instanceof String) {
				nbCreditsRecherche = (String) obj;
			}
		}

	}

	@Override
	public Object getProperty(int propertyIndex) {
		if (propertyIndex == 0) {
			return code;
		}
		if (propertyIndex == 1) {
			return libelle;
		}
		if (propertyIndex == 2) {
			return profil;
		}
		if (propertyIndex == 3) {
			return statut;
		}
		if (propertyIndex == 4) {
			return sessionDebut;
		}
		if (propertyIndex == 5) {
			return sessionFin;
		}
		if (propertyIndex == 6) {
			return moyenne;
		}
		if (propertyIndex == 7) {
			return nbEquivalences;
		}
		if (propertyIndex == 8) {
			return nbCrsReussis;
		}
		if (propertyIndex == 9) {
			return nbCrsEchoues;
		}
		if (propertyIndex == 10) {
			return nbCreditsInscrits;
		}
		if (propertyIndex == 11) {
			return nbCreditsCompletes;
		}
		if (propertyIndex == 12) {
			return nbCreditsPotentiels;
		}
		if (propertyIndex == 13) {
			return nbCreditsRecherche;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 14;
	}

	@Override
	public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		if (propertyIndex == +0) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "code";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +1) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "libelle";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +2) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "profil";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +3) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "statut";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +4) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "sessionDebut";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +5) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "sessionFin";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +6) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "moyenne";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +7) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "nbEquivalences";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +8) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "nbCrsReussis";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +9) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "nbCrsEchoues";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +10) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "nbCreditsInscrits";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +11) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "nbCreditsCompletes";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +12) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "nbCreditsPotentiels";
			info.namespace = "http://etsmtl.ca/";
		}
		if (propertyIndex == +13) {
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "nbCreditsRecherche";
			info.namespace = "http://etsmtl.ca/";
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
	}

}
