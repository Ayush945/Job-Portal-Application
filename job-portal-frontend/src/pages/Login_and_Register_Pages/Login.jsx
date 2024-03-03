import React from 'react'
import { Link } from 'react-router-dom'
import loginImage from './../../Images/LoginPageImage.jpg'
import loginText from './../../Images/LoginText.png';
function Login() {
    return (
        <div className='flex min-h-screen bg-cyan-100'>
            <div>
                <img
                    src={loginImage}
                    className=' max-h-screen'
                />
            </div>
            <div>
                <form className='flex bg-white flex-col border p-24 mt-44 ml-32 rounded-md shadow-lg shadow-purple-400'>
                    <img
                        src={loginText}
                        className=' max-h-screen'
                    />
                    <input
                        placeholder='Email'
                        className=' outline-none mb-5'
                    />
                    <input
                        placeholder='Password'
                        className='outline-none mb-5'
                    />
                    <Link className='mb-5 hover:text-blue-400'>Forget Password?</Link>
                    <button className='border rounded-md bg-blue-400 text-white hover:bg-blue-600 '><p className=' mr-4 ml-4 mt-1 mb-1'>Log in</p></button>
                    <p className='mt-5'>No account yet?</p>
                    <Link to='/register-jobSeeker' className='text-blue-400 hover:text-blue-600'>Register</Link>
                </form>
            </div>

        </div >
    )
}

export default Login