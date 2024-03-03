import React from 'react'
import registerText from './../../Images/RegisterText.png'
import { Link } from 'react-router-dom'
function RegisterCompany() {
    return (
        <div className='flex items-center min-h-screen justify-center'>
            <form className='flex bg-white flex-col items-center p-16 border rounded-md shadow-lg shadow-purple-400'>
                <img
                    src={registerText}
                    className=' max-h-screen'
                />
                <input
                    placeholder='Company Name'
                    className=' outline-none mb-5'
                />
                <input
                    placeholder='Company Username'
                    className=' outline-none mb-5'
                />
                <input
                    placeholder='Company Email'
                    className=' outline-none mb-5'
                />
                <input
                    placeholder='Company Phone number'
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
                <Link to='/login-company' className='text-blue-400 hover:text-blue-600'>Company Login</Link>

            </form>
        </div>

    )
}

export default RegisterCompany