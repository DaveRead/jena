/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.sparql.vocabulary;

/* CVS $Id: VocabTestQuery.java,v 1.1 2005/05/21 12:58:35 andy_seaborne Exp $ */
 
import org.apache.jena.rdf.model.Model ;
import org.apache.jena.rdf.model.ModelFactory ;
import org.apache.jena.rdf.model.Property ;
import org.apache.jena.rdf.model.Resource ;
 
/**
 * Vocabulary definitions from test-query.n3 
 * @author Auto-generated by schemagen on 26 Jul 2004 15:01 
 */
public class VocabTestQuery {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string ({@value})</p> */
    public static final String NS = "http://www.w3.org/2001/sw/DataAccess/tests/test-query#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>The query to ask</p> */
    public static final Property query = m_model.createProperty( "http://www.w3.org/2001/sw/DataAccess/tests/test-query#query" );
    
    /** <p>Optional: data for the query test</p> */
    public static final Property data = m_model.createProperty( "http://www.w3.org/2001/sw/DataAccess/tests/test-query#data" );

    /** <p>Optional: data for the query test</p> */
    public static final Property graphData = m_model.createProperty( "http://www.w3.org/2001/sw/DataAccess/tests/test-query#graphData" );

    
    /** <p>The class of query tests</p> */
    public static final Resource QueryTest = m_model.createResource( "http://www.w3.org/2001/sw/DataAccess/tests/test-query#QueryTest" );
    
}
