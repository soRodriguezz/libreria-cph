import React , {useState ,useEffect } from 'react'
import {Col,Row,Button , Table ,Modal,Input,DatePicker , Select,Space  } from 'antd'
import 'antd/dist/antd.min.css'
import axios from 'axios'

export default function HomeBook(){
    const [description , setDescription ] = useState('');
    const [title , setTitle ] = useState('');
    const [year , setYear ] = useState('');
    const [id , setId ] = useState(0);
    // const [categoriId , setCategoriId] = useState()
    const [isModalVisible, setIsModalVisible] = useState(false);

    const [data, setData] = useState([]);
    // const [categorias, setCategorias] = useState([]);

    const onChangePiker = (date, dateString) => {
        setYear(dateString)
    };
    const { Option } = Select;

      

    const createBook =  ()=>{
       
        const headers = {
            'Content-Type': 'application/json',
          
        }
        axios.put('http://localhost:8080/libro/',{
            id: id,
            titulo: title,
            year:year,
            description: description,
        }, {headers : headers}).then(_res =>{
            getData();
            setTitle('');
            setYear('');
            setId('');
            setDescription('');
            setIsModalVisible(false);
        })

    }
    const columns = [
        {
          titulo: 'titulo',
          dataIndex: 'titulo',
        },
        {
          title: 'year',
          dataIndex: 'year',
        },
        {
          title: 'description',
          dataIndex: 'description',
        },
        {
            title: 'Acción',
            key: 'accion',
            render: (_, record) => (
            <Space size="middle">
                <Button onClick={()=>deleteBook(record.id)} danger>Eliminar Libro</Button>
                <Button onClick={()=> {
                    showModal()
                    getBookById(record.id)
                }} type="primary">Editar Libro</Button>
            </Space>
            ),
        }
        /*{
            title: 'categoria',
            dataIndex: 'categoria',
            key: 'categoria',
            render: categoria => <p>{categoria.description}</p>
          },*/

      ];
    

      const showModal = () => {
        setIsModalVisible(true);
      };
    
    //   const handleOk = () => {
    //     setIsModalVisible(false);
    //   };
    
      const handleCancel = () => {
        setTitle('');
        setYear('');
        setDescription('');
        setId('');
        setIsModalVisible(false);
      };
    

    useEffect(()=>{
        // getCategorias();
        getData();
    },[])

    const getData = ()=>{
        axios.get('http://localhost:8080/libro').then(resp=>{
            setData(resp.data);
        })
    }

    const deleteBook = (id)=>{
        axios.delete(`http://localhost:8080/libro/${id}`).then(_resp=>{
            getData();
        })
    }

    // const getCategorias = () =>{
    //     axios.get('http://localhost:8080/categoria').then(resp=>{
    //         setCategorias(resp.data)
    //     })
    // }

    const getBookById = (id) =>{
        axios.get(`http://localhost:8080/libro/${id}`).then(resp=>{
            // console.log(resp.data.id);
            // const date = new Date(resp.data.year);
            // const yearBook = `${date.getFullYear()}-${date.getMonth()}-${date.getDate()}`;
            setTitle(resp.data.titulo);
            setDescription(resp.data.description);
            setYear(resp.data.year);
            setId(resp.data.id);
        })
    }

    // const handleChangeSelect = (value) => {
    //     setCategoriId(value)
    //   };
    return (
        <>
            <Row>
                <Col span={6}></Col>
                <Col span={6}></Col>
                <Col span={6}></Col>
                <Col span={6}><Button onClick={()=>showModal()}>Agregar Libro</Button></Col>
            </Row>
            <Row>
                <Col span={24}>
                
                <Table dataSource={data} columns={columns} />;

                </Col>
                <Modal title="Basic Modal" visible={isModalVisible} onOk={createBook} onCancel={handleCancel}>
                            <Input 
                                value={title}
                                placeholder="titutlo" 
                                onChange={(event)=> setTitle(event.target.value) }
                                />
                                <Input 
                                value={description}
                                placeholder="DESCRIPTCIO" 
                                onChange={(event)=> setDescription(event.target.value) }
                                />
                                <DatePicker onChange={onChangePiker} />
                            {/* <DatePicker onChange={onChangePiker} />
                            <Select defaultValue="lucy" style={{ width: 120 }} onChange={handleChangeSelect}>
                                    {
                                        categorias.map(c =>{
                                            return(
                                                <Option value={c.id}>{c.typo}</Option>
                                            )
                                           
                                            
                                        })
                                    }
                                    
                          </Select> */}   
                </Modal>
            </Row>
        </>
    )
}