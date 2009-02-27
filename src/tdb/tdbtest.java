/*
 * (c) Copyright 2009 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package tdb;

import java.io.File;
import java.io.PrintStream;

import org.junit.internal.TextListener;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.hp.hpl.jena.tdb.ConfigTest;
import com.hp.hpl.jena.tdb.InstallationTest;
import com.hp.hpl.jena.tdb.TDB;


public class tdbtest
{
    public static void main(String ... argv)
    {
        //ensureDir("tmp") ;
        ensureDir(ConfigTest.testingDir) ; 
        
        PrintStream out = System.out ;
        if ( TDB.VERSION.equals("DEV") )
            out.printf("TDB test suite (development)\n") ;
        else
            out.printf("TDB v%s test suite (Built: %s)\n", TDB.VERSION, TDB.BUILD_DATE) ;
        JUnitCore runner = new org.junit.runner.JUnitCore() ;
        runner.addListener(new MyTextListener(out)) ;
        Result result = runner.run(InstallationTest.class) ;
        
        if ( result.getFailureCount() > 0 )
            System.exit(1) ;
        
    }

    private static void ensureDir(String dirname)
    {
        File dir = new File(dirname) ;
        if ( ! dir.exists() )
            dir.mkdir() ;
    }

    static class MyTextListener extends TextListener
    {

        private PrintStream out ;
        int count = 0 ;

        public MyTextListener(PrintStream writer)
        {
            super(writer) ;
            this.out = writer ;
        }
        
        @Override
        public void testRunStarted(Description description)
        {
            //count = 0 ;
        }
        
        @Override
        public void testStarted(Description description) {
            newline() ;
            out.append('.');
        }

        private void newline()
        {
            if ( count != 0 && count%50 == 0 )
                out.println();
            count++ ;
        }

        @Override
        public void testFailure(Failure failure) {
            newline() ;
            out.append('E');
        }

        @Override
        public void testIgnored(Description description) {
            newline() ;
            out.append('I');
        }
        
    }
}

/*
 * (c) Copyright 2009 Hewlett-Packard Development Company, LP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */