/*
 * Kimios - Document Management System Software
 * Copyright (C) 2008-2015  DevLib'
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * aong with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kimios.webservices.converter;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.kimios.webservices.KimiosExtension;
import org.kimios.webservices.exceptions.DMServiceException;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Path("/converter")
@WebService(targetNamespace = "http://kimios.org", serviceName = "ConverterService")
@CrossOriginResourceSharing(allowAllOrigins = true)
public interface ConverterService extends KimiosExtension {

    /**
     * Get the last document version and convert to given converter class name
     */
    @GET
    @Path("/convertDocument")
    @Produces(value = {
            MediaType.APPLICATION_OCTET_STREAM,
            MediaType.APPLICATION_JSON
    })
    Response convertDocument(
            @QueryParam(value = "sessionId") @WebParam(name = "sessionId") String sessionId,
            @QueryParam(value = "documentId") @WebParam(name = "documentId") Long documentId,
            @QueryParam(value = "converterImpl") @WebParam(name = "converterImpl") String converterImpl,
            @DefaultValue("true") @QueryParam(value = "inline") @WebParam(name = "inline") Boolean inline)
            throws DMServiceException;


    /**
     * Get the last document version and convert to given converter class name
     */
    @GET
    @Path("/convertDocumentUrlOnly")
    @Produces(value = {
            MediaType.APPLICATION_OCTET_STREAM,
            MediaType.APPLICATION_JSON
    })
    String convertDocumentUrlOnly(
            @QueryParam(value = "sessionId") @WebParam(name = "sessionId") String sessionId,
            @QueryParam(value = "documentId") @WebParam(name = "documentId") Long documentId,
            @QueryParam(value = "converterImpl") @WebParam(name = "converterImpl") String converterImpl)
            throws DMServiceException;

    /**
     * Convert to converter class name for the given document version
     */
    @GET
    @Path("/convertDocumentVersion")
    @Produces(value = {
            MediaType.APPLICATION_OCTET_STREAM,
            MediaType.APPLICATION_JSON
    })
    Response convertDocumentVersion(
            @QueryParam(value = "sessionId") @WebParam(name = "sessionId") String sessionId,
            @QueryParam(value = "versionId") @WebParam(name = "versionId") Long versionId,
            @QueryParam(value = "converterImpl") @WebParam(name = "converterImpl") String converterImpl,
            @DefaultValue("true") @QueryParam(value = "inline") @WebParam(name = "inline") Boolean inline)
            throws DMServiceException;

    /**
     * Get the last versions and convert to given converter class name
     */
    @GET
    @Path("/convertDocuments")
    @Produces(value = {
            MediaType.APPLICATION_OCTET_STREAM,
            MediaType.APPLICATION_JSON
    })
    Response convertDocuments(
            @QueryParam(value = "sessionId") @WebParam(name = "sessionId") String sessionId,
            @QueryParam(value = "documentId") @WebParam(name = "documentId") Long[] documentIds,
            @QueryParam(value = "converterImpl") @WebParam(name = "converterImpl") String converterImpl,
            @DefaultValue("true") @QueryParam(value = "inline") @WebParam(name = "inline") Boolean inline)
            throws DMServiceException;

    /**
     * Convert to converter class name for the given versions
     */
    @GET
    @Path("/convertDocumentVersions")
    @Produces(value = {
            MediaType.APPLICATION_OCTET_STREAM,
            MediaType.APPLICATION_JSON
    })
    Response convertDocumentVersions(
            @QueryParam(value = "sessionId") @WebParam(name = "sessionId") String sessionId,
            @QueryParam(value = "versionId") @WebParam(name = "versionId") Long[] versionIds,
            @QueryParam(value = "converterImpl") @WebParam(name = "converterImpl") String converterImpl,
            @DefaultValue("true") @QueryParam(value = "inline") @WebParam(name = "inline") Boolean inline)
            throws DMServiceException;
}
