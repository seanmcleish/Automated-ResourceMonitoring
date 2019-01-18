/******************************************************************************
* Copyright (c) 2000-2018 Ericsson Telecom AB
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html
*
* Contributors:
*   Eduard Czimbalmos - initial implementation and initial documentation
*   Istvan Ovary
*   Peter Dimitrov
*   Balasko Jeno
*   Gabor Szalai
******************************************************************************/
//
//  File:               HTTPmsg_MessageLen_Function.cc
//  Description:        HTTP Message length calculator
//  Rev:                R9B
//  Prodnr:             CNL 113 469

#include "HTTPmsg_PT.hh"
#include "HTTPmsg_Types.hh"
#include "HTTPmsg_MessageLen.hh"

using namespace HTTPmsg__Types;
using namespace HTTPmsg__PortType;

namespace HTTPmsg__MessageLen {
INTEGER f__HTTPMessage__len(OCTETSTRING const& stream) {
   HTTPMessage msg;
   TTCN_Buffer *buf_p = new TTCN_Buffer() ;
   buf_p->put_os(stream);

   int buf_len = buf_p->get_read_len();
   if( buf_len > 0)
   {
       if(f_HTTP_decodeCommon(buf_p, msg, true, false, NULL, NULL))
       {
         buf_len -= buf_p->get_read_len();
       }
       else
         buf_len = -1;


   } else buf_len = -1;
   delete buf_p;
   return buf_len;
}
}
