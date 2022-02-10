/*
package kr.co.pcninc.solutions.mask.core.api.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
public class RestControllerBase {




    // API 요청에 대한 기본 성공 메시지
    protected static final ResponseEntity<HttpResponse<String>> SUCCESS_RESPONSE =
            ResponseEntity.ok().body(new HttpResponse<>(Constants.SUCCESS));

    // AJAX 요청에 대한 기본 실패 메시지
    protected static final ResponseEntity<HttpResponse<String>> FAIL_RESPONSE =
            ResponseEntity.ok().body(new HttpResponse<>(Constants.FAILURE, Constants.FAILURE));

    */
/**
     * @fn okResponse
     * @remark
     * - AJAX 요청에 대한 성공 메시지 생성 (기본 헤더)
     * @param s
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<String>> okResponse(String s) {
        return okResponse(s, null);
    }

    */
/**
     * @fn okResponse
     * @remark
     * - AJAX 요청에 대한 성공 메시지 생성 (헤더 추가)
     * @param s
     * @param headers
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<String>> okResponse(String s, HttpHeaders headers) {

        if (headers == null) {
            return ResponseEntity.ok().body(new HttpResponse<>(s));
        } else {
            return ResponseEntity.ok().headers(headers).body(new HttpResponse<>(s));
        }

    }

    */
/**
     * @fn okResponse
     * @remark
     * - AJAX 요청에 대한 성공 메시지 생성 (오브젝트, 기본 헤더)
     * @param o
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<?>> okResponse(Object o) {
        return okResponse(o, null);
    }

    */
/**
     * @fn okResponse
     * @remark
     * - AJAX 요청에 대한 성공 메시지 생성 (오브젝트, 헤더 추가)
     * @param o
     * @param headers
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<?>> okResponse(Object o, HttpHeaders headers) {
        if (headers == null) {
            return ResponseEntity.ok().body(new HttpResponse<>(o));
        } else {
            return ResponseEntity.ok().headers(headers).body(new HttpResponse<>(o));
        }

    }

    */
/**
     * @fn failResponse
     * @remark
     * - AJAX 요청에 대한 성공 메시지 생성 (기본 헤더)
     * @param s
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<String>> failResponse(String s) {
        return failResponse(s, null);
    }

    */
/**
     * @fn failResponse
     * @remark
     * - AJAX 요청에 대한 성공 메시지 생성 (헤더 추가)
     * @param s
     * @param headers
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<String>> failResponse(String s, HttpHeaders headers) {

        if (headers == null) {
            return ResponseEntity.ok().body(new HttpResponse<>(s, Constants.FAILURE));
        } else {
            return ResponseEntity.ok().headers(headers).body(new HttpResponse<>(s, Constants.FAILURE));
        }
    }


    */
/**
     * @fn failResponse
     * @remark
     * - AJAX 요청에 대한 실패 메시지 생성 (오브젝트, 기본 헤더)
     * @param o
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<?>> failResponse(Object o) {
        return failResponse(o, null);
    }

    */
/**
     * @fn failResponse
     * @remark
     * - AJAX 요청에 대한 실패 메시지 생성 (오브젝트, 헤더 추가)
     * @param o
     * @param headers
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<?>> failResponse(Object o, HttpHeaders headers) {

        if (headers == null) {
            return ResponseEntity.ok().body(new HttpResponse<>(o, Constants.FAILURE));
        } else {
            return ResponseEntity.ok().headers(headers).body(new HttpResponse<>(o, Constants.FAILURE));
        }

    }

    protected void assertNotNull(Object o, Class<? extends HttpException> clazz) throws Exception {
        if (ObjectUtils.isNull(o)) {
            throw clazz.newInstance();
        }
    }

    protected void assertNotNull(Object o, Class<? extends HttpException> clazz, String message) throws Exception {
        assertTrue(ObjectUtils.isNotNull(o), clazz, message);
    }

    protected void assertNotEmpty(Object o, Class<? extends HttpException> clazz) throws Exception {
        if (ObjectUtils.isEmpty(o)) {
            throw clazz.newInstance();
        }
    }

    protected void assertNotEmpty(Object o, Class<? extends HttpException> clazz, String message) throws Exception {
        assertTrue(ObjectUtils.isNotEmpty(o), clazz, message);
    }

    protected void assertTrue(boolean bool, Class<? extends HttpException> clazz)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, HttpException {
        assertTrue(bool, clazz, StringUtils.EMPTY);
    }

    protected void assertTrue(boolean bool, Class<? extends HttpException> clazz, String message)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, HttpException {
        if (!bool) {
            if (StringUtils.isNotEmpty(message)) {
                Constructor<? extends HttpException> constructor = clazz.getConstructor(String.class);
                throw constructor.newInstance(message);
            } else {
                throw clazz.newInstance();
            }
        }
    }

    */
/**
     * @fn createdResponse
     * @remark
     * - API 요청에 대한 Created 메시지 생성 (201)
     * @params
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<?>> createdResponse(final Object o) {
        return response(o, HttpStatus.CREATED);
    }

    */
/**
     * @fn okResponse
     * @remark
     * - AJAX 요청에 대한 성공 메시지 생성 (기본 헤더)
     * @param s
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<String>> createdResponse(String s) {
        return createdResponse(s, null);
    }

    */
/**
     * @fn okResponse
     * @remark
     * - AJAX 요청에 대한 성공 메시지 생성 (헤더 추가)
     * @param s
     * @param headers
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<String>> createdResponse(String s, HttpHeaders headers) {

        if (headers == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new HttpResponse<>(s));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(new HttpResponse<>(s));
        }

    }

    */
/**
     * @fn response
     * @remark
     * - API 요청에 대한 성공 메시지 생성 (Status 지정)
     * @param o
     * @param status
     * @return
     *//*

    protected static ResponseEntity<HttpResponse<?>> response(final Object o, final HttpStatus status) {
        return ResponseEntity.status(status).body(new HttpResponse<>(o));
    }

    protected void debug(final String s) {
        if (log.isDebugEnabled()) {
            log.debug(s);
        }
    }

    protected void debug(final String s, Class c) {
        if (log.isDebugEnabled()) {
            log.debug(s, c);
        }
    }

    protected void debug(final Object o) {
        if (log.isDebugEnabled()) {
            log.debug("{}", o);
        }
    }

    protected void debug(final String s, final Object... args) {
        if (log.isDebugEnabled()) {
            log.debug(s, args);
        }
    }

    protected void info(final String s) {
        if (log.isInfoEnabled()) {
            log.info(s);
        }
    }

    protected void info(final String s, final Object... args) {
        if (log.isInfoEnabled()) {
            log.info(s, args);
        }
    }
}
*/
