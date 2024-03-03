/**
 * Ayush Thapa
 * Home page
 */
import React from 'react';
import { Link } from 'react-router-dom';

function Homepage() {
    return (
        <div className='min-h-screen flex flex-col justify-evenly'>
            <div className='flex justify-evenly items-center py-4 px-4 border border-gray-300 rounded-lg ml-44 mr-44 '>
                <input className='border-none focus:outline-none' placeholder='Job Title'></input>
                <p>|</p>
                <input
                    className=' border-none focus:outline-none'
                    placeholder='City or Remote'></input>
                <p>|</p>
                <div className='border border-blue-200 p-1 rounded-lg bg-blue-400 hover:bg-blue-700 cursor-pointer'><button className=' text-white ml-5 mr-5'>Search</button></div>
            </div>
            <div className=' text-center mt-10 cursor-pointer'>
                <p><Link to='post-job' className=' text-blue-400 hover:text-blue-600'>Employers: advertise a job opportunity</Link>-discover your future hire.</p>
            </div>
            <div className='flex justify-evenly cursor-pointer'>
                <div className='border shadow-md p-10 rounded-lg'>
                    <p className='font-semibold'>Best platform for freshers</p>
                </div>
                <div className='border shadow-md p-10 rounded-lg'>
                    <p className='font-semibold'>1000+ Companies</p>
                </div>
                <div className='border shadow-md p-10 rounded-lg'>
                    <p className='font-semibold'>100000+ Hired</p>
                </div>
            </div>
        </div>
    );
}

export default Homepage;
