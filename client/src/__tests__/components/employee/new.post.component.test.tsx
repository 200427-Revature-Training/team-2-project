import React from 'react';
import { NewPostComponent } from '../../../components/pages/employee/new-post/new.post.component';
import { mount, shallow } from 'enzyme';

jest.mock('../../../remote/employee.remote');

const mockfn = jest.fn();

const setUp = (props={}) => {
    const component = shallow(<NewPostComponent {...props} />);
    return component;
}

describe('NewPostComponent', () => {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    test('should render', () => {
        const wrapper = setUp();
        // console.log(wrapper.debug());
        expect(wrapper).toBeDefined();
    });

    test('Should change the value of the title input', () => {
        const wrapper = shallow(<NewPostComponent />);
        const input = wrapper.find('#title')
        input.simulate('change', {target: {value: ''}});

        console.log(input.props());
        expect(input.prop('value')).toBe('');
    });

    test('Should change the value of the message input', () => {
        const wrapper = shallow(<NewPostComponent />);
        const input = wrapper.find('#message')
        input.simulate('change', {target: {value: ''}});

        console.log(input.props());
        expect(input.prop('value')).toBe('');
    });

    test('Should change the value of the status input', () => {
        const wrapper = shallow(<NewPostComponent />);
        const input = wrapper.find('#ticket-status')
        input.simulate('change', {target: {value: 0}});

        console.log(input.props());
        expect(input.prop('value')).toBe(0);
    });

}); 