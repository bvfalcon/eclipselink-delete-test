# eclipselink-delete-test
Test demonstrates an error during execution DELETE Operation with Eclipselink 3

Run with command `mvn` and see output:

<details><summary>Internal Exception: java.lang.NullPointerException
        at org.eclipse.persistence.internal.jpa.jpql.HermesParser.buildUnexpectedException(HermesParser.java:203)</summary>

```
Starting test
Case 1 with entity name without identificationVariable gives a correct result
Case 2 with entity canonical class name without identificationVariable gives an error:
java.lang.IllegalArgumentException: An exception occurred while creating a query in EntityManager: 
Exception Description: Internal problem encountered while compiling [DELETE FROM name.bychkov.test.Example].
Internal Exception: java.lang.NullPointerException
        at org.eclipse.persistence.internal.jpa.EntityManagerImpl.createQuery(EntityManagerImpl.java:1751)
        at name.bychkov.test.Test.main(Test.java:27)
        at org.codehaus.mojo.exec.ExecJavaMojo$1.run(ExecJavaMojo.java:279)
        at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: Exception [EclipseLink-0] (Eclipse Persistence Services - 3.0.3.v202208191135): org.eclipse.persistence.exceptions.JPQLException
Exception Description: Internal problem encountered while compiling [DELETE FROM name.bychkov.test.Example].
Internal Exception: java.lang.NullPointerException
        at org.eclipse.persistence.internal.jpa.jpql.HermesParser.buildUnexpectedException(HermesParser.java:203)
        at org.eclipse.persistence.internal.jpa.jpql.HermesParser.populateQueryImp(HermesParser.java:289)
        at org.eclipse.persistence.internal.jpa.jpql.HermesParser.buildQuery(HermesParser.java:162)
        at org.eclipse.persistence.internal.jpa.EJBQueryImpl.buildEJBQLDatabaseQuery(EJBQueryImpl.java:142)
        at org.eclipse.persistence.internal.jpa.EJBQueryImpl.buildEJBQLDatabaseQuery(EJBQueryImpl.java:118)
        at org.eclipse.persistence.internal.jpa.EJBQueryImpl.<init>(EJBQueryImpl.java:104)
        at org.eclipse.persistence.internal.jpa.EJBQueryImpl.<init>(EJBQueryImpl.java:88)
        at org.eclipse.persistence.internal.jpa.EntityManagerImpl.createQuery(EntityManagerImpl.java:1749)
        ... 3 more
Caused by: java.lang.NullPointerException
        at org.eclipse.persistence.jpa.jpql.parser.IdentificationVariable.getVariableName(IdentificationVariable.java:161)
        at org.eclipse.persistence.internal.jpa.jpql.EclipseLinkSemanticValidatorHelper.addIdentificationVariable(EclipseLinkSemanticValidatorHelper.java:64)
        at org.eclipse.persistence.internal.jpa.jpql.EclipseLinkSemanticValidatorHelper.collectLocalDeclarationIdentificationVariables(EclipseLinkSemanticValidatorHelper.java:99)
        at org.eclipse.persistence.internal.jpa.jpql.EclipseLinkSemanticValidatorHelper.collectLocalDeclarationIdentificationVariables(EclipseLinkSemanticValidatorHelper.java:110)
        at org.eclipse.persistence.jpa.jpql.AbstractSemanticValidator.validateIdentificationVariables(AbstractSemanticValidator.java:1572)
        at org.eclipse.persistence.jpa.jpql.AbstractSemanticValidator.visit(AbstractSemanticValidator.java:2838)
        at org.eclipse.persistence.jpa.jpql.parser.JPQLExpression.accept(JPQLExpression.java:135)
        at org.eclipse.persistence.internal.jpa.jpql.HermesParser.validate(HermesParser.java:334)
        at org.eclipse.persistence.internal.jpa.jpql.HermesParser.populateQueryImp(HermesParser.java:271)
        ... 9 more
Case 3 with entity canonical class name with identificationVariable gives a correct result
Test finished

```
</details>

Explanation:

Execution of `DELETE FROM name.bychkov.test.Example` gives an error, but execution `DELETE FROM name.bychkov.test.Example x` works correctly.
