import React from 'react'
import registerImage from './../../Images/RegisterPageImage.jpg'
import registerText from './../../Images/RegisterText.png'
import { Link } from 'react-router-dom'

function RegisterJobSeeker() {

    return (
        <div className='flex min-h-screen bg-cyan-100'>
            <div>
                <img
                    src={registerImage}
                    className=' max-h-screen'
                />
            </div>
            <div className='flex items-center ml-52'>
                <form className='flex bg-white flex-col items-center p-16 border rounded-md shadow-lg shadow-purple-400'>
                    <img
                        src={registerText}
                        className=' max-h-screen'
                    />
                    <input
                        placeholder='Full Name'
                        className=' outline-none mb-5'
                    />
                    <input
                        placeholder='Username'
                        className=' outline-none mb-5'
                    />
                    <input
                        placeholder='Email'
                        className=' outline-none mb-5'
                    />
                    <input
                        placeholder='Phone number'
                        className=' outline-none mb-5'
                    />
                    <input
                        placeholder='Password'
                        className='outline-none mb-5'
                    />
                    <input
                        placeholder='Confirm Password'
                        className=' outline-none mb-5'
                    />
                    <button className='border rounded-md bg-blue-400 text-white hover:bg-blue-600 '><p className=' mr-4 ml-4 mt-1 mb-1'>Register</p></button>
                    <p className='mt-5'>Already have an account?</p>
                    <Link to='/login' className='text-blue-400 hover:text-blue-600'>Login</Link>

                </form>
            </div>

        </div >
    )
}

export default RegisterJobSeeker