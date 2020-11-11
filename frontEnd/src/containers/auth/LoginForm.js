import React, {useEffect} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import{changeField, initializeForm} from '../../modules/auth';
import AuthForm from '../../components/auth/AuthForm';


/**
 * onChange 함수와 onSubmit 함수를 구현하여 필요한 액션을 디스패치하도록 함
 */
const LoginForm = () => {
    const dispatch = useDispatch();
    const {form} = useSelector(({auth}) =>({
        form: auth.login
    }));

    // 인풋 변경 이벤트 핸들러
    const onChange = e => {
        const{value, name} = e.target;
        dispatch(
            changeField({
                form:'login',
                key: name,
                value
            })
        );
    };

    // 폼 등록 이벤트 핸들러
    const onSubmit = e => {
        e.preventDefault();
        // 구현 예정
    };

    /**
     * 컴포넌트가 처음 렌더링 될 떄 form을 초기화 함
     * 맨처음 렌더링후 initializeForm 액션 생성 함수 호출하여,
     *  로그인 페이지에서 값을 입력한 뒤 다른 페이지로 이동했다 다시 돌아왔을 때 값이 유지된 상태로 보이지 않도록 함
     */
    useEffect(()=>{
        dispatch(initializeForm('login'));
    }, [dispatch]);

    return(
        <AuthForm 
        type="login"
        form={form}
        onChange={onChange}
        onSubmit={onSubmit}
        />
    );  
};

export default LoginForm;