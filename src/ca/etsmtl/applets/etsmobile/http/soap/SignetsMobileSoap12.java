package ca.etsmtl.applets.etsmobile.http.soap;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 2.0.0.4
//
// Created by Quasar Development at 15-01-2014
//
//---------------------------------------------------

import java.util.List;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.transport.HttpTransportSE;

import android.os.AsyncTask;
import ca.etsmtl.applets.etsmobile.model.Etudiant;
import ca.etsmtl.applets.etsmobile.model.ListeDeCours;
import ca.etsmtl.applets.etsmobile.model.ListeDeSessions;
import ca.etsmtl.applets.etsmobile.model.ListeDesElementsEvaluation;
import ca.etsmtl.applets.etsmobile.model.OperationResult;
import ca.etsmtl.applets.etsmobile.model.listeCoursHoraire;
import ca.etsmtl.applets.etsmobile.model.listeDesActivitesEtProf;
import ca.etsmtl.applets.etsmobile.model.listeDesCoequipiers;
import ca.etsmtl.applets.etsmobile.model.listeDesProgrammes;
import ca.etsmtl.applets.etsmobile.model.listeJoursRemplaces;

public class SignetsMobileSoap12 {
	interface IWcfMethod {
		ExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws java.lang.Exception;

		Object ProcessResult(ExtendedSoapSerializationEnvelope envelope, SoapObject result)
				throws java.lang.Exception;
	}

	String url = "https://signets-ens.etsmtl.ca/Secure/WebServices/SignetsMobile.asmx";
	int timeOut = 60000;
	public List<HeaderProperty> httpHeaders;

	IServiceEvents callback;

	public SignetsMobileSoap12() {
	}

	public SignetsMobileSoap12(IServiceEvents callback) {
		this.callback = callback;
	}

	public SignetsMobileSoap12(IServiceEvents callback, String url) {
		this.callback = callback;
		this.url = url;
	}

	public SignetsMobileSoap12(IServiceEvents callback, String url, int timeOut) {
		this.callback = callback;
		this.url = url;
		this.timeOut = timeOut;
	}

	protected org.ksoap2.transport.Transport createTransport() {
		return new HttpTransportSE(url, timeOut);
	}

	protected ExtendedSoapSerializationEnvelope createEnvelope() {
		return new ExtendedSoapSerializationEnvelope();
	}

	protected void sendRequest(String methodName, ExtendedSoapSerializationEnvelope envelope,
			org.ksoap2.transport.Transport transport) throws java.lang.Exception {
		transport.call(methodName, envelope, httpHeaders);
	}

	Object getResult(Class destObj, SoapObject source, String resultName,
			ExtendedSoapSerializationEnvelope __envelope) throws java.lang.Exception {
		if (source.hasProperty(resultName)) {
			Object j = source.getProperty(resultName);
			if (j == null) {
				return null;
			}
			Object instance = __envelope.get((AttributeContainer) j, destObj);
			return instance;
		} else if (source.getName().equals(resultName)) {
			Object instance = __envelope.get(source, destObj);
			return instance;
		}
		return null;
	}

	public String HelloWorld() throws java.lang.Exception {
		return (String) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "HelloWorld");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				Object obj = __result.getProperty("HelloWorldResult");
				if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j = (SoapPrimitive) __result.getProperty("HelloWorldResult");
					return j.toString();
				}
				return null;
			}
		}, "http://etsmtl.ca/HelloWorld");
	}

	public void HelloWorldAsync() {
		executeAsync(new Functions.IFunc<String>() {
			public String Func() throws java.lang.Exception {
				return HelloWorld();
			}
		});
	}

	public String echo(final String chaine) throws java.lang.Exception {
		return (String) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "echo");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "chaine";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(chaine);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				Object obj = __result.getProperty("echoResult");
				if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j = (SoapPrimitive) __result.getProperty("echoResult");
					return j.toString();
				}
				return null;
			}
		}, "http://etsmtl.ca/echo");
	}

	public void echoAsync(final String chaine) {
		executeAsync(new Functions.IFunc<String>() {
			public String Func() throws java.lang.Exception {
				return echo(chaine);
			}
		});
	}

	/**
	 * Information de base sur l'étudiant: nom, prénom, code permanent, solde
	 */
	public Etudiant infoEtudiant(final String codeAccesUniversel, final String motPasse)
			throws java.lang.Exception {
		return (Etudiant) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "infoEtudiant");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (Etudiant) getResult(Etudiant.class, __result, "infoEtudiantResult",
						__envelope);
			}
		}, "http://etsmtl.ca/infoEtudiant");
	}

	/**
	 * Information de base sur l'étudiant: nom, prénom, code permanent, solde
	 */
	public void infoEtudiantAsync(final String codeAccesUniversel, final String motPasse) {
		executeAsync(new Functions.IFunc<Etudiant>() {
			public Etudiant Func() throws java.lang.Exception {
				return infoEtudiant(codeAccesUniversel, motPasse);
			}
		});
	}

	/**
	 * Liste de tous les cours de l'étudiant: sigle, groupe, session,
	 * programme, cote finale, nombre de crédits et titre du cours, triée par
	 * session et sigle.
	 */
	public ListeDeCours listeCours(final String codeAccesUniversel, final String motPasse)
			throws java.lang.Exception {
		return (ListeDeCours) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "listeCours");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (ListeDeCours) getResult(ListeDeCours.class, __result, "listeCoursResult",
						__envelope);
			}
		}, "http://etsmtl.ca/listeCours");
	}

	/**
	 * Liste de tous les cours de l'étudiant: sigle, groupe, session,
	 * programme, cote finale, nombre de crédits et titre du cours, triée par
	 * session et sigle.
	 */
	public void listeCoursAsync(final String codeAccesUniversel, final String motPasse) {
		executeAsync(new Functions.IFunc<ListeDeCours>() {
			public ListeDeCours Func() throws java.lang.Exception {
				return listeCours(codeAccesUniversel, motPasse);
			}
		});
	}

	/**
	 * Retourne 'true' si le code d'accès universel et le mot de passe sont
	 * valides dans AD des étudiants
	 */
	public Boolean donneesAuthentificationValides(final String codeAccesUniversel,
			final String motPasse) throws java.lang.Exception {
		return (Boolean) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/",
						"donneesAuthentificationValides");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				Object obj = __result.getProperty("donneesAuthentificationValidesResult");
				if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j = (SoapPrimitive) __result.getProperty("donneesAuthentificationValidesResult");
					return new Boolean(j.toString());
				}
				return null;
			}
		}, "http://etsmtl.ca/donneesAuthentificationValides");
	}

	/**
	 * Retourne 'true' si le code d'accès universel et le mot de passe sont
	 * valides dans AD des étudiants
	 */
	public void donneesAuthentificationValidesAsync(final String codeAccesUniversel,
			final String motPasse) {
		executeAsync(new Functions.IFunc<Boolean>() {
			public Boolean Func() throws java.lang.Exception {
				return donneesAuthentificationValides(codeAccesUniversel, motPasse);
			}
		});
	}

	/**
	 * Liste des cours de l'étudiant entre deux sessions : sigle, groupe,
	 * session, programme, cote finale, nombre de crédits et titre du cours,
	 * triée par session et sigle.
	 */
	public ListeDeCours listeCoursIntervalleSessions(final String codeAccesUniversel,
			final String motPasse, final String SesDebut, final String SesFin)
			throws java.lang.Exception {
		return (ListeDeCours) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/",
						"listeCoursIntervalleSessions");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "SesDebut";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(SesDebut);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "SesFin";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(SesFin);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (ListeDeCours) getResult(ListeDeCours.class, __result,
						"listeCoursIntervalleSessionsResult", __envelope);
			}
		}, "http://etsmtl.ca/listeCoursIntervalleSessions");
	}

	/**
	 * Liste des cours de l'étudiant entre deux sessions : sigle, groupe,
	 * session, programme, cote finale, nombre de crédits et titre du cours,
	 * triée par session et sigle.
	 */
	public void listeCoursIntervalleSessionsAsync(final String codeAccesUniversel,
			final String motPasse, final String SesDebut, final String SesFin) {
		executeAsync(new Functions.IFunc<ListeDeCours>() {
			public ListeDeCours Func() throws java.lang.Exception {
				return listeCoursIntervalleSessions(codeAccesUniversel, motPasse, SesDebut, SesFin);
			}
		});
	}

	/**
	 * Liste de toutes les sessions où l'étudiant a été actif à l'ÉTS, en
	 * version courte (A2011) et longue (Automne 2011)
	 */
	public ListeDeSessions listeSessions(final String codeAccesUniversel, final String motPasse)
			throws java.lang.Exception {
		return (ListeDeSessions) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "listeSessions");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (ListeDeSessions) getResult(ListeDeSessions.class, __result,
						"listeSessionsResult", __envelope);
			}
		}, "http://etsmtl.ca/listeSessions");
	}

	/**
	 * Liste de toutes les sessions où l'étudiant a été actif à l'ÉTS, en
	 * version courte (A2011) et longue (Automne 2011)
	 */
	public void listeSessionsAsync(final String codeAccesUniversel, final String motPasse) {
		executeAsync(new Functions.IFunc<ListeDeSessions>() {
			public ListeDeSessions Func() throws java.lang.Exception {
				return listeSessions(codeAccesUniversel, motPasse);
			}
		});
	}

	/**
	 * Liste des programmes d'études de l'étudiant: code, libellé, moyenne,
	 * crédits réussis, etc.)
	 */
	public listeDesProgrammes listeProgrammes(final String codeAccesUniversel, final String motPasse)
			throws java.lang.Exception {
		return (listeDesProgrammes) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "listeProgrammes");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (listeDesProgrammes) getResult(listeDesProgrammes.class, __result,
						"listeProgrammesResult", __envelope);
			}
		}, "http://etsmtl.ca/listeProgrammes");
	}

	/**
	 * Liste des programmes d'études de l'étudiant: code, libellé, moyenne,
	 * crédits réussis, etc.)
	 */
	public void listeProgrammesAsync(final String codeAccesUniversel, final String motPasse) {
		executeAsync(new Functions.IFunc<listeDesProgrammes>() {
			public listeDesProgrammes Func() throws java.lang.Exception {
				return listeProgrammes(codeAccesUniversel, motPasse);
			}
		});
	}

	/**
	 * Liste de coéquipiers de l'étudiant pour le cours-groupe et l'élément
	 * d'évaluation passés en paramêtre: nom, prénom et courriel
	 */
	public listeDesCoequipiers listeCoequipiers(final String codeAccesUniversel,
			final String motPasse, final String pSigle, final String pGroupe,
			final String pSession, final String pNomElementEval) throws java.lang.Exception {
		return (listeDesCoequipiers) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "listeCoequipiers");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pSigle";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pSigle);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pGroupe";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pGroupe);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pSession";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pSession);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pNomElementEval";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pNomElementEval);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (listeDesCoequipiers) getResult(listeDesCoequipiers.class, __result,
						"listeCoequipiersResult", __envelope);
			}
		}, "http://etsmtl.ca/listeCoequipiers");
	}

	/**
	 * Liste de coéquipiers de l'étudiant pour le cours-groupe et l'élément
	 * d'évaluation passés en paramêtre: nom, prénom et courriel
	 */
	public void listeCoequipiersAsync(final String codeAccesUniversel, final String motPasse,
			final String pSigle, final String pGroupe, final String pSession,
			final String pNomElementEval) {
		executeAsync(new Functions.IFunc<listeDesCoequipiers>() {
			public listeDesCoequipiers Func() throws java.lang.Exception {
				return listeCoequipiers(codeAccesUniversel, motPasse, pSigle, pGroupe, pSession,
						pNomElementEval);
			}
		});
	}

	/**
	 * Liste des éléments d'évaluation (devoirs, labos, examens, etc.) avec
	 * la note obtenue et les statisques, comme dans SIGNETS
	 */
	public ListeDesElementsEvaluation listeElementsEvaluation(final String codeAccesUniversel,
			final String motPasse, final String pSigle, final String pGroupe, final String pSession)
			throws java.lang.Exception {
		return (ListeDesElementsEvaluation) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/",
						"listeElementsEvaluation");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pSigle";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pSigle);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pGroupe";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pGroupe);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pSession";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pSession);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (ListeDesElementsEvaluation) getResult(ListeDesElementsEvaluation.class,
						__result, "listeElementsEvaluationResult", __envelope);
			}
		}, "http://etsmtl.ca/listeElementsEvaluation");
	}

	/**
	 * Liste des éléments d'évaluation (devoirs, labos, examens, etc.) avec
	 * la note obtenue et les statisques, comme dans SIGNETS
	 */
	public void listeElementsEvaluationAsync(final String codeAccesUniversel,
			final String motPasse, final String pSigle, final String pGroupe, final String pSession) {
		executeAsync(new Functions.IFunc<ListeDesElementsEvaluation>() {
			public ListeDesElementsEvaluation Func() throws java.lang.Exception {
				return listeElementsEvaluation(codeAccesUniversel, motPasse, pSigle, pGroupe,
						pSession);
			}
		});
	}

	/**
	 * Liste de activités (cours, TP, Lab, etc) avec leur horaire et leur
	 * local, ainsi que les enseignants
	 */
	public listeDesActivitesEtProf listeHoraireEtProf(final String codeAccesUniversel,
			final String motPasse, final String pSession) throws java.lang.Exception {
		return (listeDesActivitesEtProf) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "listeHoraireEtProf");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "codeAccesUniversel";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(codeAccesUniversel);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "motPasse";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(motPasse);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pSession";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pSession);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (listeDesActivitesEtProf) getResult(listeDesActivitesEtProf.class, __result,
						"listeHoraireEtProfResult", __envelope);
			}
		}, "http://etsmtl.ca/listeHoraireEtProf");
	}

	/**
	 * Liste de activités (cours, TP, Lab, etc) avec leur horaire et leur
	 * local, ainsi que les enseignants
	 */
	public void listeHoraireEtProfAsync(final String codeAccesUniversel, final String motPasse,
			final String pSession) {
		executeAsync(new Functions.IFunc<listeDesActivitesEtProf>() {
			public listeDesActivitesEtProf Func() throws java.lang.Exception {
				return listeHoraireEtProf(codeAccesUniversel, motPasse, pSession);
			}
		});
	}

	/**
	 * Liste des cours pour le trimestre et le sigle de cours partiel passés en
	 * paramètres. Tous les CTN1 à l'hiver 2012, par exemple
	 */
	public listeCoursHoraire lireHoraire(final String pSession, final String prefixeSigleCours)
			throws java.lang.Exception {
		return (listeCoursHoraire) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "lireHoraire");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pSession";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pSession);
				__soapReq.addProperty(__info);
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "prefixeSigleCours";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(prefixeSigleCours);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (listeCoursHoraire) getResult(listeCoursHoraire.class, __result,
						"lireHoraireResult", __envelope);
			}
		}, "http://etsmtl.ca/lireHoraire");
	}

	/**
	 * Liste des cours pour le trimestre et le sigle de cours partiel passés en
	 * paramètres. Tous les CTN1 à l'hiver 2012, par exemple
	 */
	public void lireHoraireAsync(final String pSession, final String prefixeSigleCours) {
		executeAsync(new Functions.IFunc<listeCoursHoraire>() {
			public listeCoursHoraire Func() throws java.lang.Exception {
				return lireHoraire(pSession, prefixeSigleCours);
			}
		});
	}

	/**
	 * Liste des jours qui en remplacent d'autres, par exemple, les cours du
	 * lundi 8 octobre sont donnés le mercredi 21 novembre.
	 */
	public listeJoursRemplaces lireJoursRemplaces(final String pSession) throws java.lang.Exception {
		return (listeJoursRemplaces) execute(new IWcfMethod() {
			@Override
			public ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
				ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
				SoapObject __soapReq = new SoapObject("http://etsmtl.ca/", "lireJoursRemplaces");
				__envelope.setOutputSoapObject(__soapReq);

				PropertyInfo __info = null;
				__info = new PropertyInfo();
				__info.namespace = "http://etsmtl.ca/";
				__info.name = "pSession";
				__info.type = PropertyInfo.STRING_CLASS;
				__info.setValue(pSession);
				__soapReq.addProperty(__info);
				return __envelope;
			}

			@Override
			public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,
					SoapObject __result) throws java.lang.Exception {
				return (listeJoursRemplaces) getResult(listeJoursRemplaces.class, __result,
						"lireJoursRemplacesResult", __envelope);
			}
		}, "http://etsmtl.ca/lireJoursRemplaces");
	}

	/**
	 * Liste des jours qui en remplacent d'autres, par exemple, les cours du
	 * lundi 8 octobre sont donnés le mercredi 21 novembre.
	 */
	public void lireJoursRemplacesAsync(final String pSession) {
		executeAsync(new Functions.IFunc<listeJoursRemplaces>() {
			public listeJoursRemplaces Func() throws java.lang.Exception {
				return lireJoursRemplaces(pSession);
			}
		});
	}

	protected Object execute(IWcfMethod wcfMethod, String methodName) throws java.lang.Exception {
		org.ksoap2.transport.Transport __httpTransport = createTransport();
		ExtendedSoapSerializationEnvelope __envelope = wcfMethod.CreateSoapEnvelope();
		sendRequest(methodName, __envelope, __httpTransport);
		Object __retObj = __envelope.bodyIn;
		if (__retObj instanceof SoapFault) {
			SoapFault __fault = (SoapFault) __retObj;
			throw convertToException(__fault, __envelope);
		} else {
			SoapObject __result = (SoapObject) __retObj;
			return wcfMethod.ProcessResult(__envelope, __result);
		}
	}

	protected <T> void executeAsync(final Functions.IFunc<T> func) {
		new AsyncTask<Void, Void, OperationResult<T>>() {
			@Override
			protected void onPreExecute() {
				callback.Starting();
			};

			@Override
			protected OperationResult<T> doInBackground(Void... params) {
				OperationResult<T> result = new OperationResult<T>();
				try {
					result.Result = func.Func();
				} catch (java.lang.Exception ex) {
					ex.printStackTrace();
					result.Exception = ex;
				}
				return result;
			}

			@Override
			protected void onPostExecute(OperationResult<T> result) {
				callback.Completed(result);
			}
		}.execute();
	}

	java.lang.Exception convertToException(SoapFault fault,
			ExtendedSoapSerializationEnvelope envelope) {
		return new java.lang.Exception(fault.faultstring);
	}
}
