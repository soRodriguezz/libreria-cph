import React , {useEffect, useState} from "react";
import axios from 'axios'
import {Input , Col , Row , Button} from 'antd'
import 'antd/dist/antd.min.css';
import { useNavigate } from "react-router-dom"


export default function Login (){
    const [user , setUser] = useState('')
    const [password , setPassword] = useState('')
    const navigate = useNavigate();
    useEffect(()=>{
       
    },[])


    const login = ()=>{

        console.log(user,password );
        const headers = {
            'Content-Type': 'application/json',
        }
        axios.post('http://localhost:8080/auth/',{
            "username": user,
            "password": password
        }, {headers : headers}).then(res =>{
            console.log(res);
            localStorage.setItem('token',res.data.token)
            navigate('/');

        })
    }
    return(
        <>
        
            <Row>
                <Col span={12}>
                    <Input placeholder="Usuario"
                        value={user}
                        onChange = {(event)=> setUser(event.target.value)}
                    ></Input>

                </Col>    
                <Col span={12}>
                    <Input placeholder="Password"
                    value={password}
                    onChange = {(event)=> setPassword(event.target.value)}
                    >
                    </Input>
                </Col>    
            </Row>
            <Row>
               <Col>
                    <Button onClick={()=>login()} type="primary">Login</Button>
               </Col>
            </Row>
        </>
    )
}